package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r == c) 1;
    else pascal(c-1,r-1) + pascal(c,r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance(acc: Int, chars: List[Char]): Boolean ={
      if (chars.isEmpty) acc == 0      
      else if (chars.head == '(')  balance(acc + 1,chars.tail)
      else if (chars.head == ')'){
        if (acc > 0) balance(acc - 1,chars.tail)
        else false
      }
      else balance(acc,chars.tail)
    }
    balance(0,chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChangeIter(money: Int, coins: List[Int]): Int ={
      if (0 == money) 1
      else if ( coins.isEmpty) 0
      else if (money >= coins.head) {
        countChangeIter(money - coins.head, coins) +         
        countChangeIter(money, coins.tail)
      }
      else{
        countChangeIter(money, coins.tail)
      }
    }      
    countChangeIter(money, coins)
    
  }
}
