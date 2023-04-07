package main;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    int shift;

    ROT13(Character cs, Character cf) {
        if(cs>cf){
            shift = cs-cf;
        } else{
            shift = cf-cs;
        }
        //System.out.println(shift);
    }

    ROT13() {
        shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {


        return encrypt(text);
    }

    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();

        for(char c: text.toCharArray()){
            if((c > 78 && c < 91) || (c > 108 && c < 123)){
                encrypted.append((char) (c - 13));
            } else if((c > 64 && c<77) || (c > 96 && c < 109) ){
                encrypted.append((char) (c + 13));
            }else {
                encrypted.append(c);
            }

        }

        return encrypted.toString();
    }

    public String decrypt(String text) {
        return encrypt(text);
    }

    public String rotate(String s, Character c) {
        StringBuilder rotated = new StringBuilder();
        int val = c-65;

        for(char chars: s.toCharArray()){
            if(chars > 64 && chars < 91) {
                if (chars - val < 65) {
                    chars = (char) (chars + 26);
                }
                rotated.append((char) (chars - val));
            }
        }
        return rotated.toString();
    }
}
