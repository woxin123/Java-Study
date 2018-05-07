package org.example.collection;

/**
 * @author: mengchen
 * Create by 18-4-26
 */

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import sun.misc.SharedSecrets;


public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
    // 序列化号
    private static final long serialVersionUID = 8683452581122892189L;

    // 默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    // 一个空的数组，当用户指定容量为0时，返回该数组
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 一个空数组的实例
     * - 当用户没有指定ArrayList的容量时，也就是调用无参构造的时候，返回的是该数组   刚创建的ArrayList，其中的数据量为0
     * - 当用户第一次添加元素时，该数组将会扩容，变为默认的10（DEFAULT_CAPACITY）  通过ensureCapacityInternal()
     * 它于EMPTY_ELEMENTDATA的区别是，该数组是默认返回的，EMPTY_ELEMENTDATA是用户指定容量为0时返回的
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * ArrayList基于数组实现，该数组保存数据，ArrayList的容量就是该数组的长度
     * - 该值为DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * - 当用户第一次添加元素进入ArrayList中时，该数组将扩容为DEFAULT_CAPACITY
     */
    transient Object[] elementData; // non-private to simplify nested class access

    /**
     * ArrayList中元素的个数
     */
    private int size;

    /**
     * 创建一个初始容量的，空的ArrayList
     *
     * @param  initialCapacity  初始容量
     * @throws IllegalArgumentException 当初始容量为0时抛出
     *         is negative
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * 无参构造，返回DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 创建一个包含collection的ArrayList
     *
     * @param c 要放入ArrayList中的集合，其内元素将全部会添加到新建的ArrayList中
     * @throws NullPointerException if the specified collection is null
     */
    public ArrayList(Collection<? extends E> c) {
        // 将集合转化成数组
        elementData = c.toArray();
        if ((size = elementData.length) != 0) { // 把数组的长度赋给ArrayList的size，并判断是否为空，当不等于空时
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            // c.toArray 可能不会返回Object[]
            if (elementData.getClass() != Object[].class)
                // 若c.toArray()返回的数组不是Object[]，则利用Arrays.copyOf();来构造一个大小为size的Object[]数组
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // 替换空的数组
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 将数组的缓冲区调整到实际ArrayList存储元素的大小，即elementData = Arrays.copOf(elementData, size)
     * 该方法有用户手动调用目的是为了减少空间的浪费
     */
    public void trimToSize() {
        modCount++; // 这个是记录ArrayList修改的次数
        // 当实际的大小 < 缓冲区大小时
        // 如调用默认的构造函数后，刚添加第一个元素，此时它的缓冲区的大小为10， 可以调用该函数调整
        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 指定ArrayList的容量
     *
     * @param   minCapacity   最小容量
     */
    public void ensureCapacity(int minCapacity) {
        // 最小扩容默认为10
        // 判断是不是空的ArrayList，如果是的话，则最小扩容为10，否则为0
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : DEFAULT_CAPACITY;
        // 若用户指定的最小容量 > 最小扩充容量，则以用户指定的为准，否则还是10
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    /**
     * 私有的静态方法：明确ArrayList的容量
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        // 如果elementData为空的话，返回默认用量和minCapacity中的较大者
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // 如果不为空，返回minCapacity
        return minCapacity;
    }

    /**
     * 私有的方法：明确ArrayList的容量
     * 用户内部优化，保证空间资源不浪费：尤其在add()方法中
     * @param minCapacity 指定最小容量
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 私有的方法：明确ArrayList的容量
     * 用户内部优化，保证空间资源不浪费：尤其在add()方法中
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        // 将修改的统计次数加1
        modCount++;

        // overflow-conscious code
        // 防止溢出，确保最小容量 > 数组缓冲区的容量
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 数组缓冲区最大容量
     * The maximum size of array to allocate.
     * - 一些VM会在一个数组中存储某些介质 为什么减8的原因
     * - 尝试分配这个最大存储容量，可能会导致OutOfMemoryError(当该值 > VM 限制时)
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 私有方法：扩容，以确保能存储minCapacity个元素
     * - 扩容计算：newCapacity = oldCapacity + (oldCapacity >> 1); 扩容是当前容量的1.5倍
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity 指定最小容量
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)   // 如果扩容
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 私有方法：最大容量分配，最大分配Integer.MAX_VALUE
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        // 小于0，抛出异常 OutOfMemoryError
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        // 指定最小的容量大于最大能分配的容量，返回Integer.MAX_VALUE，否则返回能分配的最大值
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 返回ArrayList实际存储的元素数量
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * ArrayList中是否有元素
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含o元素
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 返回o元素最先出现的位置
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     */
    public int indexOf(Object o) {
        // 当o == null ，遍历找到第一个null的位置
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            // 如果o不为null, 那么遍历找最先出现的位置
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        // 如果没有找到返回-1
        return -1;
    }

    /**
     * 最后出现的位置，与index()类似，只是该方法遍历时是倒着遍历
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    /**
     * 实现Cloneable接口，深度复制
     * Returns a shallow copy of this <tt>ArrayList</tt> instance.  (The
     * elements themselves are not copied.)
     *
     * @return a clone of this <tt>ArrayList</tt> instance
     */
    public Object clone() {
        try {
            // Object的克隆会复制本对象的其内的基本类型和String类型，但不会复制对象
            ArrayList<?> v = (ArrayList<?>) super.clone();
            // 将elemetData进行复制
            v.elementData = Arrays.copyOf(elementData, size);
            // 因为复制出来的是新的，没有被修改过，所以modCount初始化为0
            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    /**
     * 将该数组转化成Object数组
     * - 包含ArrayList的所有元素
     * - 对返回的数组操作，不会影响ArrayList
     * - 元素的存储与ArrayList一致
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in
     *         proper sequence
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 返回ArrayList元素组成的数组
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element); the runtime type of the returned
     * array is that of the specified array.  If the list fits in the
     * specified array, it is returned therein.  Otherwise, a new array is
     * allocated with the runtime type of the specified array and the size of
     * this list.
     *
     * <p>If the list fits in the specified array with room to spare
     * (i.e., the array has more elements than the list), the element in
     * the array immediately following the end of the collection is set to
     * <tt>null</tt>.  (This is useful in determining the length of the
     * list <i>only</i> if the caller knows that the list does not contain
     * any null elements.)
     *
     * @param a the array into which the elements of the list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     *          a 需要存储在list元素中的数组，若a.length >= a.size，则将list中的元素按顺序存入a中，然后a[list.size] = null,
     *          a[list.size + 1]及其以后的元素依旧是a中的元素
     *          否则，将返回包含list所有元素的商都等于list中元素个数的数组
     *          注意：若a中本来就存储有元素，则a会被list的元素覆盖，且a[list.size] = null
     * @return an array containing the elements of the list
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list    当a.getClass() != list中存储的元素类型时
     * @throws NullPointerException if the specified array is null 当a为null时
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        // 若a.length < size时新建一个T[]数组
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        // 若数组a的大小 >= ArrayList中元素的个数，则将ArrayList中的元素全部拷贝到a数组中
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    // Positional Access Operations
    //

    /**
     * 返回在索引在index出的元素：数组随机访问
     * - 默认包访问权限
     * 将取值封装避免每次强转
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 获取指定位置的元素，从0开始
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    /**
     * 设置index位置的索引
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace 索引值
     * @param element element to be stored at the specified position index位置的元素值
     * @return the element previously at the specified position 返回该索引处之前的值
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {
        rangeCheck(index);  // 范围检查

        E oldValue = elementData(index);    // 获取之前的值
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Appends the specified element to the end of this list.
     * 将指定的元素添加到ArrayList最后的位置
     * @param e element to be appended to this list
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     */
    public boolean add(E e) {
        // 确保ArrayList的容量
        // 保证要存多少个元素，就分配多少的空间
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    /**
     * 在这个ArrayList中指定位置插入指定的元素
     * - 在指定位置之前插入新的元素，原先的index位置往后移动一位
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);    // 检查是否越界
        ensureCapacityInternal(size + 1);  // Increments modCount!! 同上
        // 第一个是要复制的数组，第二个是开始位置，第二个复制到哪，第四个是复制的长度
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    /**
     * 删除指定位置的元素
     * index后的索引元素一次左移一位
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed index指定位置
     * @return the element that was removed from the list   被移出的元素
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E remove(int index) {
        // 检查index越界
        rangeCheck(index);
        // 修改次数加一
        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;    // 要移动的长度
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        // 将最后一个元素置空
        elementData[--size] = null; // clear to let GC do its work

        return oldValue;
    }

    /**
     * 移出list中指定的第一个元素（符合条件索引的最低值）
     * 如果ArrayList中不包含这个元素，那么ArrayList将不会被改变
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>
     * (if such an element exists).  Returns <tt>true</tt> if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(Object o) {
        // 如过o = null
        if (o == null) {    // 遍历找到null
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    /*
     * 快速删除第index个元素
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work 将最后一个元素清除
    }

    /**
     * 删除该list中的所有元素
     * - 他会将数组缓冲区所有元素置为null
     * - 清除之后，打印list会出现[], 而不是null, 这是因为toSting()和迭代器处理了
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        modCount++;

        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    /**
     * 讲一个集合中的所有元素追加到list的末尾
     * - ArrayList是线程不安全的，当一个线程正在将c中的元素添加到list中，但同时另一个线程在更改c中的元素，可能会有问题
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
     * specified collection's Iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param c collection containing elements to be added to this list 要追加的集合
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(Collection<? extends E> c) {
        // 将c转化为一个object数组
        Object[] a = c.toArray();
        // 要追加的元素的个数
        int numNew = a.length;
        // 扩容
        ensureCapacityInternal(size + numNew);  // Increments modCount
        // 复制
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     * 从 ArrayList 指定位置开始插入c.length个元素（原来在此处的n个元素一次右移）
     * Inserts all of the elements in the specified collection into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).  The new elements will appear
     * in the list in the order that they are returned by the
     * specified collection's iterator.
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        // 越界检查
        rangeCheckForAdd(index);

        Object[] a = c.toArray();   // 将集合转为数组
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount 扩容

        int numMoved = size - index; // 移动的元素数量
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     * 移出list中[fromIndex,toIndex]的元素
     *
     * Removes from this list all of the elements whose index is between
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.
     * Shifts any succeeding elements to the left (reduces their index).
     * This call shortens the list by {@code (toIndex - fromIndex)} elements.
     * (If {@code toIndex==fromIndex}, this operation has no effect.)
     *
     * @throws IndexOutOfBoundsException if {@code fromIndex} or
     *         {@code toIndex} is out of range
     *         ({@code fromIndex < 0 ||
     *          fromIndex >= size() ||
     *          toIndex > size() ||
     *          toIndex < fromIndex})
     */
    protected void removeRange(int fromIndex, int toIndex) {
        modCount++;
        int numMoved = size - toIndex;  // 要移动的数量
        System.arraycopy(elementData, toIndex, elementData, fromIndex,
                numMoved);

        // clear to let GC do its work
        int newSize = size - (toIndex-fromIndex);
        // 将失效元素置空
        for (int i = newSize; i < size; i++) {
            elementData[i] = null;
        }
        size = newSize;
    }

    /**
     * 范围检查，如果超过范围，抛出数组越界异常
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 范围检查用于add和addAll
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 构建IndexOutOfBoundsException的详细消息
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * 移出list中指定集合中包含的元素
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this list
     *          要从list中移出的指定集合
     * @return {@code true} if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of this list
     *         is incompatible with the specified collection
     *         如果list中包含的一个元素和指定集合中不兼容
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     *         specified collection does not permit null elements
     *         如果list中包含一个空元素，而指定集合中不允许有空元素
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see Collection#contains(Object)
     */
    public boolean removeAll(Collection<?> c) {
        /**
         * public static <T> T requireNonNull(T obj) {
         *         if (obj == null)
         *             throw new NullPointerException();
         *         return obj;
         *     }
         */
        Objects.requireNonNull(c);  // 判断集合是否为空，如果为空报NullPointerException
        // 批量移出c集合的元素，第二个参数：是否采补集
        return batchRemove(c, false);
    }

    /**
     * 移出lis中除了指定集合中的元素之外的元素
     * Retains only the elements in this list that are contained in the
     * specified collection.  In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     * @throws ClassCastException if the class of an element of this list
     *         is incompatible with the specified collection
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if this list contains a null element and the
     *         specified collection does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see Collection#contains(Object)
     */
    public boolean retainAll(Collection<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    /**
     * 批处理移出
     * @param c　要移出的集合
     * @param complement　是否采补集
     *                  true: 移出list中出除了ｃ集合中的所有元素
     *                  false: 移出list中c集合中的元素
     * @return
     */
    private boolean batchRemove(Collection<?> c, boolean complement) {

        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            // 遍历数组，并检查这个集合中是否有对应的值，移动要保留的值到数组的前面，w为最后得到保留的值的数量
            // 如果保留：将相同的元素移动前段，如果不保留：将不同的元素移动前段
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            // 因为最后有一个for循环中有一个r++，所以r最后肯定=size
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            // 如果r!=size表示可能出错
            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }
            // 如果w = size：表示所有的元素都保留了，所以也就没有删除发生
            // 而　w !=　size；即使try抛出异常，也能正常处理异常抛出钱的操作，
            // 因为w始终为要保留的前半部分，数组也不会因此乱序
            if (w != size) {
                // 将w～size之间的全部都置空
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    /**
     * 私有方法
     * 将ArrayList实例序列化
     * Save the state of the <tt>ArrayList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The length of the array backing the <tt>ArrayList</tt>
     *             instance is emitted (int), followed by all of its elements
     *             (each an <tt>Object</tt>) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        // Write out element count, and any hidden stuff
        // 写入所有元素数量的任何隐藏东西
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        // 写入clone行为的容量大小
        s.writeInt(size);

        // Write out all elements in the proper order.
        // 以合适的顺序写入所有的元素
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 私有的方法
     * 以反序列化中重构ArrayList实例
     * Reconstitute the <tt>ArrayList</tt> instance from a stream (that is,
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // 读出大小和隐藏的东西
        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        //　读出大小
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            // 从输入流将“所有元素读出”
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }

    /**
     * 返回从指定索引到结束的list迭代器
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: "+index);
        return new ListItr(index);
    }

    /**
     * 以一种合适的排序返回一个iterator到元素的末尾
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * <p>The returned list iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @see #listIterator(int)
     */
    public ListIterator<E> listIterator() {
        return new ListItr(0);
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * <p>The returned iterator is <a href="#fail-fast"><i>fail-fast</i></a>.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * Itr是Abstract.Itr的优化版
     * 为什么会报一个ConcurrentModificationException异常？
     * 1. Iterator是工作在一个独立的线程中的，并且拥有一个mutex锁。
     * 2. Iterator被创建之后会建立一个指向原来对象的单链表的索引，当原来的对象的数量发生改变时，
     * 这个索引表的内容不会同步改变，所以当指针往后移的时候就找不到要迭代的对象了
     * 3. 所以按照fail-fast原则Iterator马上会抛出一个java.util.ConcurrentModificationException异常
     * 4. 所以Iterator工作的时候是不允许迭代的对象被改变
     * An optimized version of AbstractList.Itr
     */
    private class Itr implements Iterator<E>{
        // 下一个元素的索引
        int cursor;       // index of next element to return
        // 最后一个元素的索引
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;

        Itr() {}

        // 是否有下一个元素
        public boolean hasNext() {
            return cursor != size;
        }

        // 返回list中的值
        @SuppressWarnings("unchecked")
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            // 第二次检查，list集合中数量是否发生变化
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;  // 一下个元素的索引
            return (E) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                // 移出list中元素
                ArrayList.this.remove(lastRet);
                // 由于cursor比lastRet大１，所以这行代码是将指针往回移动一位
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * jdk1.8中使用的方法
         * 将list中的所有元素都给了consumer，这个方法可以取出元素
         * @param consumer
         */
        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            final int size = ArrayList.this.size;
            int i = cursor;
            if (i >= size) {
                return;
            }
            final Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length) {
                throw new ConcurrentModificationException();
            }
            while (i != size && modCount == expectedModCount) {
                consumer.accept((E) elementData[i++]);
            }
            // update once at end of iteration to reduce heap write traffic
            cursor = i;
            lastRet = i - 1;
            checkForComodification();
        }

        /**
         * 检查这两个值是否相等
         * 在迭代器时list集合中的元素数量发生变化时会造成这两个值不相等
         */
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    /**
     * ＡbstractList.ListItr的优化版
     * ListItr与普通Iterator的区别
     * - 它可以进行双向移动，而普通的迭代器只能进行单向移动
     * - 它可以添加元素，而普通的迭代器不行
     * An optimized version of AbstractList.ListItr
     */
    private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        // 是否有前一个元素
        public boolean hasPrevious() {
            return cursor != 0;
        }

        // 获取下一个元素的索引
        public int nextIndex() {
            return cursor;
        }

        /**
         * 获取cursor前一个元素的索引
         * - 是cursor前一个，而不是当前元素的前一个的索引
         * - 如果调用next()方法后立即调用该方法，获取的是当前元素的索引
         * @return
         */
        public int previousIndex() {
            return cursor - 1;
        }

        //　返回cursor前一元素
        @SuppressWarnings("unchecked")
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)  // 检查是否越界
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                // 将数组最后一个元素设置为e
                ArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E e) {
            checkForComodification();

            try {
                // 当前元素后移一位
                int i = cursor;
                ArrayList.this.add(i, e);   // 在i的位置添加元素e
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /**
     * 获取fromIndex到toIndex之间的子集合
     * - 若fromIndex == toIndex，则返回空集合
     * - 对该子集合操作，会影响原有的集合
     * - 当调用了subList()后，若对原有的集合进行操作，会抛出java.util.ConcurrentModificationException
     *  这个和Itr的原因差不多由于modCount发生了改变，对集合的操作需要用子集合提供的方法
     * - 该子集合支持所有的集合操作
     * Returns a view of the portion of this list between the specified
     * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive.  (If
     * {@code fromIndex} and {@code toIndex} are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations.
     *
     * <p>This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>
     *      list.subList(from, to).clear();
     * </pre>
     * Similar idioms may be constructed for {@link #indexOf(Object)} and
     * {@link #lastIndexOf(Object)}, and all of the algorithms in the
     * {@link Collections} class can be applied to a subList.
     *
     * <p>The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    public List<E> subList(int fromIndex, int toIndex) {
        subListRangeCheck(fromIndex, toIndex, size);
        return new ArrayList.SubList(this, 0, fromIndex, toIndex);
    }

    // 检查传入值的合法性
    // 注意[fromIndex, toIndex)
    static void subListRangeCheck(int fromIndex, int toIndex, int size) {
        if (fromIndex < 0)
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        if (toIndex > size)
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        if (fromIndex > toIndex)
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
    }

    /**
     * 私有类
     * 嵌套内部类：是实现了RandomAccess,提供快速随机访问
     */
    private class SubList extends java.util.AbstractList<E> implements RandomAccess {
        private final AbstractList<E> parent;   // 实际传入的是ArrayList本身
        private final int parentOffset;         // 相对于父集合的偏移量，其实就是fromIndex
        private final int offset;               // 偏移量，默认为0
        int size;                               // SubList中的元素个数

        /**
         * 子集合中的元素只是将父集合的元素映射，并没有复制
         * 因为有final的修饰，所以截取子集合后，父集合不能删除SubList中的有个元素——offset不能更改
         * @param parent
         * @param offset
         * @param fromIndex
         * @param toIndex
         */
        SubList(AbstractList<E> parent,
                int offset, int fromIndex, int toIndex) {
            this.parent = parent;
            this.parentOffset = fromIndex;
            this.offset = offset + fromIndex;
            this.size = toIndex - fromIndex;
            this.modCount = ArrayList.this.modCount;
        }

        /**
         * 设置新值，返回旧值
         * @param index
         * @param e
         * @return
         */
        public E set(int index, E e) {
            rangeCheck(index);          // 检查越界
            checkForComodification();   //
            // 从这里可以看出：对子集合添加元素，是直接对父类添加的
            E oldValue = ArrayList.this.elementData(offset + index);
            ArrayList.this.elementData[offset + index] = e;
            return oldValue;
        }

        // 获取指定索引的元素
        public E get(int index) {
            rangeCheck(index);
            checkForComodification();
            return org.example.collection.ArrayList.this.elementData(offset + index);
        }

        // 返回元素数量
        public int size() {
            checkForComodification();
            return this.size;
        }

        // 添加元素
        public void add(int index, E e) {
            rangeCheckForAdd(index);
            checkForComodification();
            // 中这里也可以看，index+offset得到添加的索引在父类中的索引，然后调用父类的方法。
            parent.add(parentOffset + index, e);
            this.modCount = parent.modCount;
            this.size++;
        }

        public E remove(int index) {
            rangeCheck(index);
            checkForComodification();
            // 移出指定位置的元素
            E result = parent.remove(parentOffset + index);
            this.modCount = parent.modCount;
            this.size--;
            return result;
        }

        // 移出subList中的[from, toIndex]之间的元素
        protected void removeRange(int fromIndex, int toIndex) {
            checkForComodification();
            parent.removeRange(parentOffset + fromIndex,
                    parentOffset + toIndex);
            this.modCount = parent.modCount;
            this.size -= toIndex - fromIndex;
        }

        // 添加集合中的元素到list结尾
        public boolean addAll(Collection<? extends E> c) {
            return addAll(this.size, c);
        }

        // 在subList指定位置，添加集合元素
        public boolean addAll(int index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            int cSize = c.size();
            if (cSize==0)
                return false;

            checkForComodification();
            parent.addAll(parentOffset + index, c);
            this.modCount = parent.modCount;
            this.size += cSize;
            return true;
        }

        /**
         * subList中的迭代器
         * @return
         */
        public Iterator<E> iterator() {
            return listIterator();
        }

        /**
         * 返回从指定索引开始到结束的带有元素的list迭代器
         * @param index
         * @return
         */
        public ListIterator<E> listIterator(final int index) {
            checkForComodification();
            rangeCheckForAdd(index);        // 越界检查，按理来说这个方法只提供给add()进行检查，但是在这里也可以，但...
            final int offset = this.offset; // 偏移量

            return new ListIterator<E>() {
                int cursor = index;
                int lastRet = -1;       // 上一个返回元素的索引，若没有上一个则为-1，每次调用remove()，lastRet都会被置为-1
                int expectedModCount = ArrayList.this.modCount;

                public boolean hasNext() {
                    return cursor != ArrayList.SubList.this.size;   // 是否有下一个元素的判断
                }

                @SuppressWarnings("unchecked")
                public E next() {
                    checkForComodification();
                    // 练市变量i，指向有效当前位置
                    int i = cursor;
                    if (i >= ArrayList.SubList.this.size)           // 第一次检查
                        throw new NoSuchElementException();
                    Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length)           // 第二次检查
                        throw new ConcurrentModificationException();
                    cursor = i + 1;
                    return (E) elementData[offset + (lastRet = i)]; // 这里lastRet会被重新赋值
                }


                public boolean hasPrevious() {
                    return cursor != 0;
                }

                @SuppressWarnings("unchecked")
                public E previous() {
                    checkForComodification();
                    int i = cursor - 1;
                    if (i < 0)
                        throw new NoSuchElementException();
                    Object[] elementData = org.example.collection.ArrayList.this.elementData;
                    if (offset + i >= elementData.length)
                        throw new ConcurrentModificationException();
                    cursor = i;
                    return (E) elementData[offset + (lastRet = i)];
                }

                @SuppressWarnings("unchecked")
                public void forEachRemaining(Consumer<? super E> consumer) {
                    Objects.requireNonNull(consumer);
                    final int size = ArrayList.SubList.this.size;
                    int i = cursor;
                    if (i >= size) {
                        return;
                    }
                    final Object[] elementData = ArrayList.this.elementData;
                    if (offset + i >= elementData.length) {
                        throw new ConcurrentModificationException();
                    }
                    while (i != size && modCount == expectedModCount) {
                        consumer.accept((E) elementData[offset + (i++)]);
                    }
                    // update once at end of iteration to reduce heap write traffic
                    lastRet = cursor = i;
                    checkForComodification();
                }

                public int nextIndex() {
                    return cursor;
                }

                public int previousIndex() {
                    return cursor - 1;
                }

                public void remove() {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        SubList.this.remove(lastRet);
                        cursor = lastRet;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void set(E e) {
                    if (lastRet < 0)
                        throw new IllegalStateException();
                    checkForComodification();

                    try {
                        ArrayList.this.set(offset + lastRet, e);
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                public void add(E e) {
                    checkForComodification();

                    try {
                        int i = cursor;
                        ArrayList.SubList.this.add(i, e);
                        cursor = i + 1;
                        lastRet = -1;
                        expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException ex) {
                        throw new ConcurrentModificationException();
                    }
                }

                final void checkForComodification() {
                    if (expectedModCount != ArrayList.this.modCount)
                        throw new ConcurrentModificationException();
                }
            };
        }

        public List<E> subList(int fromIndex, int toIndex) {
            subListRangeCheck(fromIndex, toIndex, size);
            return new ArrayList.SubList(this, offset, fromIndex, toIndex);
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > this.size)
                throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }

        private String outOfBoundsMsg(int index) {
            return "Index: "+index+", Size: "+this.size;
        }

        private void checkForComodification() {
            if (ArrayList.this.modCount != this.modCount)
                throw new ConcurrentModificationException();
        }

        /**
         * 获取一个分割器
         * @return
         */
        public Spliterator<E> spliterator() {
            checkForComodification();
            return new ArrayList.ArrayListSpliterator<E>(ArrayList.this, offset,
                    offset + this.size, this.modCount);
        }
    }

    /**
     * jdk1.8的方法，用于函数式编程
     * @param action
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        @SuppressWarnings("unchecked")
        final E[] elementData = (E[]) this.elementData;
        final int size = this.size;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            action.accept(elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    /**
     * 获取一个分割器
     * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
     * and <em>fail-fast</em> {@link Spliterator} over the elements in this
     * list.
     *
     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
     * {@link Spliterator#SUBSIZED}, and {@link Spliterator#ORDERED}.
     * Overriding implementations should document the reporting of additional
     * characteristic values.
     *
     * @return a {@code Spliterator} over the elements in this list
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return new org.example.collection.ArrayList.ArrayListSpliterator<>(this, 0, -1, 0);
    }

    // 基于索引的、二分的、懒加载器
    /** Index-based split-by-two, lazily initialized Spliterator */
    static final class ArrayListSpliterator<E> implements Spliterator<E> {

        /*
         * If ArrayLists were immutable, or structurally immutable (no
         * adds, removes, etc), we could implement their spliterators
         * with Arrays.spliterator. Instead we detect as much
         * interference during traversal as practical without
         * sacrificing much performance. We rely primarily on
         * modCounts. These are not guaranteed to detect concurrency
         * violations, and are sometimes overly conservative about
         * within-thread interference, but detect enough problems to
         * be worthwhile in practice. To carry this out, we (1) lazily
         * initialize fence and expectedModCount until the latest
         * point that we need to commit to the state we are checking
         * against; thus improving precision.  (This doesn't apply to
         * SubLists, that create spliterators with current non-lazy
         * values).  (2) We perform only a single
         * ConcurrentModificationException check at the end of forEach
         * (the most performance-sensitive method). When using forEach
         * (as opposed to iterators), we can normally only detect
         * interference after actions, not before. Further
         * CME-triggering checks apply to all other possible
         * violations of assumptions for example null or too-small
         * elementData array given its size(), that could only have
         * occurred due to interference.  This allows the inner loop
         * of forEach to run without any further checks, and
         * simplifies lambda-resolution. While this does entail a
         * number of checks, note that in the common case of
         * list.stream().forEach(a), no checks or other computation
         * occur anywhere other than inside forEach itself.  The other
         * less-often-used methods cannot take advantage of most of
         * these streamlinings.
         */

        private final org.example.collection.ArrayList<E> list;
        private int index; // current index, modified on advance/split
        private int fence; // -1 until used; then one past last index
        private int expectedModCount; // initialized when fence set

        /** Create new spliterator covering the given  range */
        ArrayListSpliterator(org.example.collection.ArrayList<E> list, int origin, int fence,
                             int expectedModCount) {
            this.list = list; // OK if null unless traversed
            this.index = origin;
            this.fence = fence;
            this.expectedModCount = expectedModCount;
        }

        private int getFence() { // initialize fence to size on first use
            int hi; // (a specialized variant appears in method forEach)
            org.example.collection.ArrayList<E> lst;
            if ((hi = fence) < 0) {
                if ((lst = list) == null)
                    hi = fence = 0;
                else {
                    expectedModCount = lst.modCount;
                    hi = fence = lst.size;
                }
            }
            return hi;
        }

        public org.example.collection.ArrayList.ArrayListSpliterator<E> trySplit() {
            int hi = getFence(), lo = index, mid = (lo + hi) >>> 1;
            return (lo >= mid) ? null : // divide range in half unless too small
                    new org.example.collection.ArrayList.ArrayListSpliterator<E>(list, lo, index = mid,
                            expectedModCount);
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (action == null)
                throw new NullPointerException();
            int hi = getFence(), i = index;
            if (i < hi) {
                index = i + 1;
                @SuppressWarnings("unchecked") E e = (E)list.elementData[i];
                action.accept(e);
                if (list.modCount != expectedModCount)
                    throw new ConcurrentModificationException();
                return true;
            }
            return false;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            int i, hi, mc; // hoist accesses and checks from loop
            org.example.collection.ArrayList<E> lst; Object[] a;
            if (action == null)
                throw new NullPointerException();
            if ((lst = list) != null && (a = lst.elementData) != null) {
                if ((hi = fence) < 0) {
                    mc = lst.modCount;
                    hi = lst.size;
                }
                else
                    mc = expectedModCount;
                if ((i = index) >= 0 && (index = hi) <= a.length) {
                    for (; i < hi; ++i) {
                        @SuppressWarnings("unchecked") E e = (E) a[i];
                        action.accept(e);
                    }
                    if (lst.modCount == mc)
                        return;
                }
            }
            throw new ConcurrentModificationException();
        }

        public long estimateSize() {
            return (long) (getFence() - index);
        }

        public int characteristics() {
            return Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;
        }
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        // figure out which elements are to be removed
        // any exception thrown from the filter predicate at this stage
        // will leave the collection unmodified
        int removeCount = 0;
        final BitSet removeSet = new BitSet(size);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            @SuppressWarnings("unchecked")
            final E element = (E) elementData[i];
            if (filter.test(element)) {
                removeSet.set(i);
                removeCount++;
            }
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }

        // shift surviving elements left over the spaces left by removed elements
        final boolean anyToRemove = removeCount > 0;
        if (anyToRemove) {
            final int newSize = size - removeCount;
            for (int i=0, j=0; (i < size) && (j < newSize); i++, j++) {
                i = removeSet.nextClearBit(i);
                elementData[j] = elementData[i];
            }
            for (int k=newSize; k < size; k++) {
                elementData[k] = null;  // Let gc do its work
            }
            this.size = newSize;
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            modCount++;
        }

        return anyToRemove;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        final int expectedModCount = modCount;
        final int size = this.size;
        for (int i=0; modCount == expectedModCount && i < size; i++) {
            elementData[i] = operator.apply((E) elementData[i]);
        }
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c) {
        final int expectedModCount = modCount;
        Arrays.sort((E[]) elementData, 0, size, c);
        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
        modCount++;
    }
}
