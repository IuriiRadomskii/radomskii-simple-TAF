package org.radomskii.simple.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Board {

    private int id;
    private String name;
    private String desc;
    private String permissionLevel;

    public Board(String name, String permissionLevel) {
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

}
