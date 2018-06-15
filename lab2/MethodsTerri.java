package lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodsTerri {

	public HashMap<Integer, List<Integer>> formSLists(int[][] matrix) {

		// Вводим массив данных для смежных списков
		HashMap<Integer, List<Integer>> vertexMap = new HashMap<Integer, List<Integer>>();
		// Вводим массивы данных для хранения вершин
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		List<Integer> list5 = new ArrayList<Integer>();
		List<Integer> list6 = new ArrayList<Integer>();
		// Формируем смежные списки
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0) {
						list1.add(j + 1);
					}
					if (i == 1) {
						list2.add(j + 1);
					}
					if (i == 2) {
						list3.add(j + 1);
					}
					if (i == 3) {
						list4.add(j + 1);
					}
					if (i == 4) {
						list5.add(j + 1);
					}
					if (i == 5) {
						list6.add(j + 1);
					}

				}
			}
		}

		vertexMap.put(1, list1);
		vertexMap.put(2, list2);
		vertexMap.put(3, list3);
		vertexMap.put(4, list4);
		vertexMap.put(5, list5);
		vertexMap.put(6, list6);
		return vertexMap;
	}

	public void showSLists(HashMap<Integer, List<Integer>> vertexMap) {
		// Выводим смежные списки
		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
			System.out.println("Вершина: " + entry.getKey() + " смежна с вершинами " + entry.getValue());
		}
	}

	public void findWay(HashMap<Integer, List<Integer>> vertexMap, int start, int end) {
		// Вводим вспомогательные переменные
		int previous1 = 0;
		int previous2 = 0;
		int previous3 = 0;
		int previous4 = 0;
		int next1 = 0;
		int next2 = 0;
		int next3 = 0;
		int next4 = 0;
		// Ищем пути
		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {

			if (start == entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int a : list) {
					if (end == a) {
						System.out.println("Путь из начальной вершины в конечную равен " + start + " " + end);
					} else if (next1 != start && a != start)
						next1 = a;

				}
			}
		}
		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
			previous1 = next1;
			if (next1 == entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int a : list) {
					if (end == a) {
						System.out.println(
								"Путь из начальной вершины в конечную равен " + start + " " + previous1 + " " + end);
					} else if (next1 != start && previous1 != start && a != start && a != next1 && a != previous1)
						next2 = a;

				}
			}
		}
		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
			previous2 = next2;
			if (next2 == entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int a : list) {
					if (end == a) {
						System.out.println("Путь из начальной вершины в конечную равен " + start + " " + previous1 + " "
								+ previous2 + " " + end);
					} else if (previous2 != start && previous2 != next1 && a != start && a != next1 && a != previous1
							&& a != previous2)
						next3 = a;

				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
			previous3 = next3;
			if (next3 == entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int a : list) {
					if (end == a) {
						System.out.println("Путь из начальной вершины в конечную равен " + start + " " + previous1 + " "
								+ previous2 + " " + previous3 + " " + end);
					} else if (previous3 != start && previous3 != next1 && previous3 != previous1
							&& previous3 != previous2 && a != start && a != next1 && a != previous1 && a != previous2
							&& a != previous3)
						next4 = a;

				}
			}
		}

		for (Map.Entry<Integer, List<Integer>> entry : vertexMap.entrySet()) {
			previous4 = next4;
			if (next4 == entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int a : list) {
					if (end == a) {
						System.out.println("Путь из начальной вершины в конечную равен " + start + " " + previous1 + " "
								+ previous2 + " " + previous3 + " " + previous4 + " " + end);
					} else
						System.out.println("Путь из начальной вершины в конечную не найден");

				}
			}
		}
	}

}
