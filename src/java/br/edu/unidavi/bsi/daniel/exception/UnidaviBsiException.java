/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unidavi.bsi.daniel.exception;

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