package top.mcwebsite.moreThread.threadlocals;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 一个栈封闭的例子
 * @author mengchen
 * @time 18-8-6 上午9:12
 */
/*
public class StackClose {
    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        // animals被封闭在线程中，不要使它们逸出
        animals = new TreeSet<>(new SpeciesGenderComparator());
        animals.addAll(candidates);

        for (Animal a : animals) {
            if (candidate == null || candidate.isPotentialMate(a)) {
                candidate = a;
            } else {
              ark.load(new AnimalPair(candidate, a));
              ++numPairs;
              candidate = null;
            }
        }
        return numPairs;
    }
}

class Animal {

    public boolean isPotentialMate(Animal a) {
        return false;
    }
}

class SpeciesGenderComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return 0;
    }
}

*/