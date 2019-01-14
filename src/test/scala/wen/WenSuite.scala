package wen

import org.scalatest.FunSuite


class WenSuite extends FunSuite{
  test("myLowerCase") {
    val tk = new Tokenizer
    assert(tk.myLowerCase("U.S.A") == "U.S.A")
    assert(tk.myLowerCase("Apple") == "apple")
  }

  test("tokenize"){
    val tk = new Tokenizer
    assert(tk.tokenize("Hello World!").toList == List("hello", "world"))
    assert(tk.tokenize("Let's (go).").toList == List("let's", "go"))
  }

  test("Lemmatizer") {
    val lm = new Lemmatizer
    assert(lm.lemmatize("cats") == "cat")
    assert(lm.lemmatize("news") == "news")
    assert(lm.lemmatize("flaking") == "flake")
  }

  test("RemoveStopWords") {
    val sw = new RemoveStopWords
    assert(sw.RemoveStopWords(Array("you", "and", "me")).toList == List())
    assert(sw.RemoveStopWords(Array("a")).toList == List())
  }

  test("HashingTF") {
    val hf = new HashingTF
    assert(hf.HashingTF(Seq("a", "b"), 2) == List(1.0, 1.0))
    assert(hf.HashingTF(Seq("a", "b"), 3) == List(0.0, 1.0, 1.0))
  }

}

