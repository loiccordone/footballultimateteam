package fr.n7.fut.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public enum Role {
    USER,
    MODERATOR,
    ADMIN
}
