package hello.core.member;

public class Member {
    private Long id;
    private String name;
    private Grade grade;
    // Alt + fn + Insert 메서드 자동 완성 단축키


    public Member(Long id ,String name ,Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


}
