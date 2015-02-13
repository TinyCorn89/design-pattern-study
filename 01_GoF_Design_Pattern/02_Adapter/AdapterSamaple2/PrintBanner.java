/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterSample2;

/**
 *
 * @author Shohei
 */
public class PrintBanner extends Print{
    private Banner banner; 
    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }
    @Override
    public void printWeak() {
        banner.showWithParen();
    }
    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
