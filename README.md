## Project Decola Tech Avanade 2025
Java RESTful API criada para o Decola Tech Avanade 2025

## Diagrama de classes 

```mermaid
classDiagram
    class Student {
        - String name
        - Registration registration
        - Course[] courses
        - News[] news
    }

    class Registration {
        - String number
        - String birth
        - String email
        - String courseName
    }

    class Course {
        - String subjects
        - String classroom
        - String schedule
    }

    class News {
        - String icon
        - String description
    }

    Student "1"*--"1" Registration
    Student "1"*--"N" Course 
    Student "1"*--"N" News 
```
