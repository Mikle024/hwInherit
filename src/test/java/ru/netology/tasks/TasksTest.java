package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void taskMatchesTest() {
        Task task = new Task(1);

        Todos todos = new Todos();

        boolean expected = false;
        boolean actual = task.matches("Встреча");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskMatchesIfTrueTest() {
        SimpleTask simpleTask = new SimpleTask(33, "Сделать уборку");

        boolean expected = true;
        boolean actual = simpleTask.matches("Сделать уборку");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskMatchesIfFalseTest() {
        SimpleTask simpleTask = new SimpleTask(33, "Сделать уборку");

        boolean expected = false;
        boolean actual = simpleTask.matches("Покормить собаку");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatchesIfTrueTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(33, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicMatchesIfFalseTest() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(33, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Курица");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void meetingMatchesProjectIfTrueTest() {
        Meeting meeting = new Meeting( 555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesTopicIfTrueTest() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingMatchesIfFalseTest() {
        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("Приложение Доставка");
    }
}
