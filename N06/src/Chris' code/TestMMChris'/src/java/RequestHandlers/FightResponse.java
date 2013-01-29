/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestHandlers;

/**
 *
 * @author cki
 */
public class FightResponse {
 FightResponse(int money, int result) {
       this.money = money;
       this.result = result;
              
    }

   
    
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    int money;
   int result;

    
}
