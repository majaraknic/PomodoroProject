package eu.execom.pomodoro.model.enumerations;

enum Status {
        STARTED,
        FINISHED,
        FAILED
}

class StatusClass {
    public static void main(String[] args) {
        Status myStatus = Status.STARTED;

        switch(myStatus) {
            case STARTED:
                System.out.println("Status = Started");
                break;
            case FINISHED:
                System.out.println("Status = Finnished");
                break;
            case FAILED:
                System.out.println("Status = Failed");
                break;
        }
    }
}
