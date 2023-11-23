package com.shopesimple.invManager.Exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoUserExist extends Exception {
    public NoUserExist(String msg) {
        super(msg);
    }
}
