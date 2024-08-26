package ru.test.backend.type;

public class ResultRegisterPerson {

    private final boolean isSuccess;
    private final Long id;
    private final String error;

    public static ResultRegisterPerson error(String error) {
        return new ResultRegisterPerson(false, null, error);
    }

    public static ResultRegisterPerson success(Long id) {
        return new ResultRegisterPerson(true, id, null);
    }

    public ResultRegisterPerson(boolean isSuccess, Long id, String error) {
        this.isSuccess = isSuccess;
        this.id = id;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Long getId() {
        return id;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "ResultRegisterPerson{" +
                "isSuccess=" + isSuccess +
                ", id=" + id +
                ", error='" + error + '\'' +
                '}';
    }
}
