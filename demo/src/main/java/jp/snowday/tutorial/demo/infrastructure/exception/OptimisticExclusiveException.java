package jp.snowday.tutorial.demo.infrastructure.exception;

import org.springframework.transaction.TransactionException;

/**
 * 楽観排他例外
 *
 * @author zhangnan
 * @date 2018/08/26
 */
public class OptimisticExclusiveException extends TransactionException {
    /**
     * Default Constructor
     * @param msg Message
     */
    public OptimisticExclusiveException(String msg) {
        super(msg);
    }

    /**
     * Default Constructor with causes
     * <br>
     * @param msg Message
     * @param cause cause
     */
    public OptimisticExclusiveException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
