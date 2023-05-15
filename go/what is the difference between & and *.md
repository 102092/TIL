```go
package main

import "fmt"

func main() {
    b := 6 

    var b_ptr *int // b_prt 은 int 가리키는 포인터임
                   

    b_ptr = &b     // 이제 해당 포인터는 b 변수를 저장하고 있는 메모리 주소를 가리킴 
                   

    fmt.Printf("address of b_ptr: %p\n", b_ptr)
    
    // 해당 포인터가 가리키고 있는 메모리 주소의 값은? derefenece..
    fmt.Printf("value stored at b_ptr: %d\n", *b_ptr)
    
}

address of b_ptr: 0xc82007c1f0
value stored at b_ptr: 6
```

- `*`  can be used for two diffenent things
	1. to declare a variable to be a pointer, 변수를 포인터처럼 선언하는 것
	2. to dereference a pointer, 해당 포인터의 dereference 가리키고 있는 변수 값을 가져오는 것?
- `&` is assigned the value of the address
	- 메모리 주소를 넘기는 것

```go
    var a = 5
    var p = &a // copy by reference, p에는 a값이 담겨있는 메모리 주소값이 담겨 있을 것
    var x = a  // copy by value

    fmt.Println("a = ", a)   // a =  5
    fmt.Println("p = ", p)   // p =  0x10414020
    fmt.Println("*p = ", *p) // *p =  5, dereference, 즉 p메모리가 가리키고 있던 값을 가져왔음
    fmt.Println("&p = ", &p) // &p =  0x1040c128 값의 메모리 주소를 가져왔고
    fmt.Println("x = ", x)   // x =  5

    fmt.Println("\n Change *p = 3")
    *p = 3 // dereference -> 3, 즉 0x10414020의 값은 3
    fmt.Println("a = ", a)   // a =  3
    fmt.Println("p = ", p)   // p =  0x10414020
    fmt.Println("*p = ", *p) // *p =  3
    fmt.Println("&p = ", &p) // &p =  0x1040c128
    fmt.Println("x = ", x)   // x =  5

    fmt.Println("\n Change a = 888")
    a = 888
    fmt.Println("a = ", a)   // a =  888
    fmt.Println("p = ", p)   // p =  0x10414020
    fmt.Println("*p = ", *p) // *p =  888
    fmt.Println("&p = ", &p) // &p =  0x1040c128
    fmt.Println("x = ", x)   // x =  5
```


## Reference
- https://stackoverflow.com/questions/33242850/in-golang-what-is-the-difference-between-and