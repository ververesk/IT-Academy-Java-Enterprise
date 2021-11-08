package com.grigirovich.db_it.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        private int id;
        private String login;
        private String password;
        private ROLE role;

        public enum ROLE {
            USER, ADMIN, UNKNOWN, TEACHER
        }
    }

