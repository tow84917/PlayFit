package com.java016.playfit.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AddMemberInfo implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name = "add to prime member";

    private String imagePath = "/images/AddMemberInfo.png";

    private String info = "";



}
