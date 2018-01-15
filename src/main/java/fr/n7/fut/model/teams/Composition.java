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

	public static List<Integer> getNeighbors(Composition comp, int position) {
		List<Integer> res = new LinkedList<>();
		switch (position) {
		case 1:
			res.add(3);
			res.add(4);
			break;
		case 2:
			switch (comp) {
			case _433:
				res.add(3);
				res.add(7);
				break;
			case _442:
				res.add(3);
				res.add(8);
				break;
			case _451:
				res.add(3);
				res.add(6);
				res.add(8);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 3:
			res.add(6);
			res.add(4);
			res.add(1);
			res.add(2);
			break;
		case 4:
			switch (comp) {
			case _433:
				res.add(6);
				res.add(3);
				res.add(5);
				res.add(1);
				break;
			case _442:
				res.add(3);
				res.add(1);
				res.add(5);
				res.add(7);
				break;
			case _451:
				res.add(1);
				res.add(3);
				res.add(5);
				res.add(7);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 5:
			switch (comp) {
			case _433:
				res.add(4);
				res.add(8);
				break;
			case _442:
				res.add(4);
				res.add(9);
				break;
			case _451:
				res.add(4);
				res.add(7);
				res.add(10);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 6:
			switch (comp) {
			case _433:
				res.add(4);
				res.add(3);
				res.add(7);
				res.add(8);
				break;
			case _442:
				res.add(3);
				res.add(8);
				res.add(2);
				res.add(10);
				break;
			case _451:
				res.add(3);
				res.add(2);
				res.add(9);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 7:
			switch (comp) {
			case _433:
				res.add(6);
				res.add(8);
				res.add(10);
				res.add(11);
				break;
			case _442:
				res.add(9);
				res.add(4);
				res.add(6);
				res.add(11);
				break;
			case _451:
				res.add(5);
				res.add(4);
				res.add(9);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 8:
			switch (comp) {
			case _433:
				res.add(6);
				res.add(7);
				res.add(10);
				res.add(11);
				break;
			case _442:
				res.add(6);
				res.add(10);
				res.add(2);
				break;
			case _451:
				res.add(9);
				res.add(11);
				res.add(2);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 9:
			switch (comp) {
			case _433:
				res.add(7);
				res.add(10);
				break;
			case _442:
				res.add(7);
				res.add(5);
				res.add(11);
				break;
			case _451:
				res.add(6);
				res.add(7);
				res.add(8);
				res.add(11);
				res.add(10);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 10:
			switch (comp) {
			case _433:
				res.add(7);
				res.add(8);
				res.add(9);
				res.add(11);
				break;
			case _442:
				res.add(8);
				res.add(6);
				res.add(11);
				break;
			case _451:
				res.add(5);
				res.add(11);
				res.add(9);
				break;
			default:
				res = null;
				break;
			}
			break;
		case 11:
			switch (comp) {
			case _433:
				res.add(8);
				res.add(10);
				break;
			case _442:
				res.add(9);
				res.add(7);
				res.add(10);
				break;
			case _451:
				res.add(10);
				res.add(8);
				res.add(9);
				break;
			default:
				res = null;
				break;
			}
			break;
		default:
			res = null;
			break;

		}
		return res;
	}

	public static Starter getInitStarter(Composition comp, int position) {
		Starter res = null;
		switch (position) {
		case 1:
			res = new Starter(FieldRole.GK, Position.GK, null);
			break;
		case 2:
			res = new Starter(FieldRole.DEF, Position.DD, null);
			break;
		case 3:
			res = new Starter(FieldRole.DEF, Position.DC, null);
			break;
		case 4:
			res = new Starter(FieldRole.DEF, Position.DC, null);
			break;
		case 5:
			res = new Starter(FieldRole.DEF, Position.DG, null);
			break;
		case 6:
			res = new Starter(FieldRole.MIL, Position.MDC, null);
			break;
		case 7:
			switch (comp) {
			case _433:
				res = new Starter(FieldRole.MIL, Position.MC, null);
				break;
			case _442:
				res = new Starter(FieldRole.MIL, Position.MDC, null);
				break;
			case _451:
				res = new Starter(FieldRole.MIL, Position.MDC, null);
				break;
			}
			break;
		case 8:
			switch (comp) {
			case _433:
				res = new Starter(FieldRole.MIL, Position.MC, null);
				break;
			case _442:
				res = new Starter(FieldRole.MIL, Position.MD, null);
				break;
			case _451:
				res = new Starter(FieldRole.MIL, Position.MD, null);
				break;
			}
			break;
		case 9:
			switch (comp) {
			case _433:
				res = new Starter(FieldRole.ATT, Position.AD, null);
				break;
			case _442:
				res = new Starter(FieldRole.MIL, Position.MG, null);
				break;
			case _451:
				res = new Starter(FieldRole.MIL, Position.MOC, null);
				break;
			}
			break;
		case 10:
			switch (comp) {
			case _433:
				res = new Starter(FieldRole.ATT, Position.BU, null);
				break;
			case _442:
				res = new Starter(FieldRole.ATT, Position.BU, null);
				break;
			case _451:
				res = new Starter(FieldRole.MIL, Position.MG, null);
				break;
			}
			break;
		case 11:
			switch (comp) {
			case _433:
				res = new Starter(FieldRole.ATT, Position.AG, null);
				break;
			case _442:
				res = new Starter(FieldRole.ATT, Position.BU, null);
				break;
			case _451:
				res = new Starter(FieldRole.ATT, Position.BU, null);
				break;
			}
			break;
		default:
			break;

		}
		return res;
	}
}
