package fr.eni.encheres;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
 private List<Integer> listeCodesErreurs;
 
public BusinessException() {
super();
this.listeCodesErreurs=new ArrayList<>();



}
 
}
