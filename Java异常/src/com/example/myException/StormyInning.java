package com.example.myException;


class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning () throws BaseballException {}
    public void event() throws BaseballException {

    }

    public abstract void atBat () throws Strike, Foul;
    public void walk() throws StormException {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{
    public StormyInning() throws RainedOut, BaseballException {}

    @Override
    public void atBat()  {

    }

    @Override
    public void rainHard()  {

    }

    @Override
    public void event()  {

    }

    public void walk() throws StormException {}

    public static void main(String[] args) throws BaseballException, RainedOut {
        try {
            new StormyInning().event();
        } catch (RainedOut rainedOut) {
            rainedOut.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
