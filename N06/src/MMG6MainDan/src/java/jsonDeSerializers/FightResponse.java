/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonDeSerializers;

/**
 *
 * @author Arom
 */
public class FightResponse {

    int money;
    int result;

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

   public FightResponse(int money, int result) {
        money = this.money;
        result = this.result;
    }
}
