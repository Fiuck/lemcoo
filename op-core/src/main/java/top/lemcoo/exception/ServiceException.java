package top.lemcoo.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }
}
