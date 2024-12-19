package chapter13;

// == 빌더로 게임 캐릭터 생성 == //
// 필수: 이름, 분류
// 선택: 스킬, 아이템

class GameCharacter {
    // 필수
    private final String name;
    private final String sort;
    // 선택
    private final String skill; // final 생략 가능. Builder 클래스에서 초기화 X
    private final String item;

    // 1) 빌더 클래스
    public static class Builder {
        private final String name;
        private final String sort;
        private String skill = "Basic Attack"; // 위에서 final을 생략했다면, = "~" 부분이 생략 가능하다.(초기화X)
        private String item = "None";

        // 생성자
        public Builder(String name, String sort) {
            this.name = name;
            this.sort = sort;
        }

        // 인스턴스 메서드 >> 메서드 체이닝(.skill().build() ...) 가능
        public Builder skill(String skill) {
            this.skill = skill;
            return this;
        }
        public Builder item(String item) {
            this.item = item;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }
    }

    public GameCharacter(Builder builder) {
        this.name = builder.name;
        this.sort = builder.sort;
        this.skill = builder.skill;
        this.item = builder.item;
    }
}

public class F_Builder {
    public static void main(String[] args) {
        GameCharacter character1 = new GameCharacter.Builder("뽀로로", "펭귄")
                .skill("크롱 놀리기")
                .item("안경")
                .build();
        GameCharacter character2 = new GameCharacter.Builder("루피", "비버")
                .skill("잔망루피")
                .item("정색")
                .build();
    }
}
