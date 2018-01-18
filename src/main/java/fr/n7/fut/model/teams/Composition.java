package fr.n7.fut.model.teams;

import java.util.LinkedList;
import java.util.List;

import fr.n7.fut.model.players.FieldRole;
import fr.n7.fut.model.players.Position;

public enum Composition {
	_433 {
		@Override
		public String toString() {
			return "4-3-3";
		}
	},
	_442 {
		@Override
		public String toString() {
			return "4-4-2";
		}
	},
	_451 {
		@Override
		public String toString() {
			return "4-5-1";
		}
	};
}
