# Kyrie User Guide

![Ui.png](../docs/Ui.png)

Welcome to Kyrie, your personal task manager! Kyrie helps you keep track of your tasks, deadlines, and events. This guide will walk you through the features and commands available in Kyrie.

## Table of Contents

1. [How to get started](#how-to-get-started)
2. [Features](#features)
   - [Adding a Todo](#adding-a-todo)
   - [Adding a Deadline](#adding-a-deadline)
   - [Adding an Event](#adding-an-event)
   - [Listing All Tasks](#listing-all-tasks)
   - [Marking a Task as Done](#marking-a-task-as-done)
   - [Unmarking a Task](#unmarking-a-task)
   - [Deleting a Task](#deleting-a-task)
   - [Finding Tasks](#finding-tasks)
   - [Tagging a Task](#tagging-a-task)
   - [Exiting the Program](#exiting-the-program)
3. [Command Summary](#command-summary)

## How to get started

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Run the application using your preferred IDE or command line.

## Features

### Adding a Todo

Adds a todo task to your task list.

**Command**: `todo <description>`

**Example**: todo read book

### Adding a Deadline

Adds a deadline task to your task list.

**Command**: `deadline <description> /by <date time>`

**Example**: deadline return book /by 21/02/2025 2000

### Adding an Event

Adds an event task to your task list.

**Command**: `event <description> /from <start date time> /to <end date time>`

**Example**: event project meeting /from 22/02/2025 0100 /to 22/02/2025 0200

### Listing All Tasks

Lists all tasks in your task list.

**Command**: `list`

### Marking a Task as Done

Marks a task as done.

**Command**: `mark <task number>`

### Unmarking a Task

Unmarks a task as done.

**Command**: `unmark <task number>`

### Deleting a Task

Deletes a task from your task list.

**Command**: `delete <task number>`

### Finding Tasks

Finds tasks that contain a keyword.

**Command**: `find <keyword>`

### Tagging a Task

Tags a task with a specified tag.

**Command**: `tag <task number> <tag>`

**Example**: tag 1 important

### Exiting the Program

Exits the Kyrie application.

**Command**: `bye`

## Command Summary

| Command         | Format                                      | Example                                      |
|-----------------|---------------------------------------------|----------------------------------------------|
| Add Todo        | `todo <description>`                        | `todo read book`                             |
| Add Deadline    | `deadline <description> /by <date time>`    | `deadline return book /by 21/02/2025 2000`   |
| Add Event       | `event <description> /from <start> /to <end>` | `event project meeting /from 22/02/2025 0100 /to 22/02/2025 0200` |
| List Tasks      | `list`                                      | `list`                                       |
| Mark Task       | `mark <task number>`                        | `mark 1`                                     |
| Unmark Task     | `unmark <task number>`                      | `unmark 1`                                   |
| Delete Task     | `delete <task number>`                      | `delete 1`                                   |
| Find Tasks      | `find <keyword>`                            | `find book`                                  |
| Tag Task        | `tag <task number> <tag>`                   | `tag 1 #important`                           |
| Exit            | `bye`                                       | `bye`                                        |


<br>

Enjoy using Kyrie to manage your tasks efficiently!