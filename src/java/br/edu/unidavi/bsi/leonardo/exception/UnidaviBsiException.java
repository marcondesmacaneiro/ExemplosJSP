package br.edu.unidavi.bsi.leonardo.exception;


public class UnidaviBsiException extends Exception {
    public UnidaviBsiException() {
    }
    
    public UnidaviBsiException(String msg) {
        super(msg);
    }
    public UnidaviBsiException(String msg, Throwable t) {
        super(msg, t);
    }
}