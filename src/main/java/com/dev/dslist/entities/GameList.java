package com.dev.dslist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Data
@Table(name = "tb_game_list ")
@AllArgsConstructor
@NoArgsConstructor
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameList gameList)) return false;
        return id == gameList.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}