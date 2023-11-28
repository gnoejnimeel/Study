package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    //이 객체 인스턴스가 필요하면 오직 해당 메소드를 통해서만 조회 가능하다.
    public static SingletonService getInstance() {
        //1개만 존재하기 때문에 호출하면 항상 같은 인스턴스 반환한다.
        return instance;
    }

    //다른 곳에서 객체 생성할 수 없다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    public static void main(String[] args) {
    }
}
