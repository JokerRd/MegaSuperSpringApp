package ru.test.backend.concurrency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@RequiredArgsConstructor
@Slf4j
public class BadTask implements Callable<Integer>, Runnable {

    private final int numberTask;
    private final BadBoy badBoy;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Начинаю работу, номер задачи {}", numberTask);
        badBoy.setMagicNumber(numberTask);
        log.info("Работу закончил, номер задачи {}", numberTask);
    }

    @Override
    public Integer call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("Начинаю работу, номер задачи {}", numberTask);
        badBoy.setMagicNumber(numberTask);
        log.info("Работу закончил, номер задачи {}", numberTask);
        return badBoy.getMagicNumber();
    }

    /// 1
    ///
    ///


}
