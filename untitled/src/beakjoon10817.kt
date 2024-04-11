import java.util.Scanner

fun main(){
    val scanner=Scanner(System.`in`)

    var a =scanner.nextInt()
    var b= scanner.nextInt()
    var c = scanner.nextInt()

    when{
        a>b&&a>c&&b>c->print(b)
        a>b&&a>c&&b<c->print(c)
        a<b&&a>c&&b>c->print(a)
        a<b&&a<c&&b>c->print(c)
        a>b&&a<c&&b<c->print(a)
        a<b&&a<c&&b<c->print(b)
        a==b->print(a)
        b==c->print(b)
        a==c->print(c)
    }
}
