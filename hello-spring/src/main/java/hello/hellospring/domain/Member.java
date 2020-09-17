package hello.hellospring.domain;

public class Member {

    private Long id;
    private String name;

    //게터 세터 = 컨트롤+인설트 단축키
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
