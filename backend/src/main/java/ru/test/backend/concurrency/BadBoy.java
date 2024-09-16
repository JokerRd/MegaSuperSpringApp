package ru.test.backend.concurrency;


public class BadBoy {

    private int magicNumber;

    public BadBoy(int magicNumber) {
        this.magicNumber = magicNumber;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public  void setMagicNumber(int magicNumber) {
        this.magicNumber = magicNumber;
    }


    /// 1 T получил  magicNumber; 2 T получил  magicNumber     1 T инкремент применил 2 T применил
    /// 2 T увеличить значение, но не успел записать
    /// 1 T увеличил
    /// 2 T записал
    /// 1 T Записал

}
