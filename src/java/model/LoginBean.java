/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author conve
 */
public class LoginBean {
    private String name;
    private String password;
    public LoginBean(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validate(){
        if(this.name.equals("admin") && this.password.equals("1234")){
            return true;
        }else{
            return false;
        }
    }
}
