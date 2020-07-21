package utilities;

public class EnumDemo {

    enum testStatus
    {
        fail , pass , reopen , closed , postpone

    }

    public static void main(String[] args)
    {
        testStatus status;

        status = testStatus.closed;

        switch(status)
        {
            case fail:
                System.out.println("status is fail"); break;
            case pass:
                System.out.println("status is pass"); break;
            case reopen:
                System.out.println("status is reopen"); break;
            case postpone:
                System.out.println("status is postpone"); break;
            case closed:
                System.out.println("status is closed"); break;
        }


    }
}
