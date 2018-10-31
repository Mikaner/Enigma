# Enigma
えにぐま＠がんばる
## 注意事項
- 想定されていない文字を入力するとぬるぽを返すので気を付けてください。
## version 1.1.1
###### 変更点
- reRotor.pyの処理をRotor.javaの中に移動。

###### 使い方
- とりあえず、コンパイルです。
  1. `javac .\Enigma.java`などと打ってコンパイルしてください。`javac`がない場合はインストールして環境を整えてきてください。
  2. `java Enigma`と打ってEnigmaを起動してください
  3. 急に止めたくなった場合は`ctrl+Z`か`ctrl+C`を押して強制終了してください。

- 次に、セッティングです。
  1. First Rotorと出るので、一番目のローターの番号と一番上の文字をセットしてください。(version 1.1.1現在ではローターは5つあります。文字は英字の大文字のみ対応しています)
  ```:入力例
  First Rotor
  1 A
  ```

  2. Second Rotorと出るので、二番目のローターの番号と一番上の文字をセットしてください。
  ```:入力例
  First Rotor
  1 A
  Second Rotor
  2 B
  ```

  3. Third Rotorと出るので、三番目のローターの番号と一番上の文字をセットしてください。
  ```:入力例
  First Rotor
  1 A
  Second Rotor
  2 B
  Third Rotor
  3 C
  ```

  4. Exchangeと出るので、入れ替えたい文字の数と入れ替えたい文字をそれぞれ指定してください。
  ```:入力例
  First Rotor
  1 A
  Second Rotor
  2 B
  Third Rotor
  3 C
  Exchange
  Number of Alphabet to exchange : 3
  A Z
  B C
  X Y
  ```

  5. 現在あるローターの数と、対応しているA~Zの入れ替える前、入れ替えた後が出力されたら、セッティングは終了です。
  ```:出力例
  First Rotor
  1 A
  Second Rotor
  2 B
  Third Rotor
  3 C
  Exchange
  Number of Alphabet to exchange : 3
  A Z
  B C
  X Y
  3
   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
   Z C B D E F G H I J K L M N O P Q R S T U V W Y X A
  Please type a message here.
  ```
- この後は文字を入力します
  1. 英字の大文字を入力してください。(空白を入れると改行されて出力されます。)
  ```:入力例
  Please type a message here.
  AAA
  ```

  2. 変換後の文字が出力されます。
  ```:出力例
  Please type a message here.
  AAA
  TIN
  ```
  ```:出力例(空白を入れた場合)
  Please type a message here.
  A AA
  T
  IN
  ```

  3. 終了するときは`"exit"`と入力してください。
  ```:入力例
  Please type a message here.
  AAA
  TIN
  "exit"
  ```

  4. 復号する際は、起動しなおして、セッティングの1から同じ設定にしてください。

## version 1.1.0
###### 変更点
- ローター5を追加。ローターの処理を変更。パターン数を増やした。新しくreRotor.pyファイルを追加。たぶんすぐ消える気がする。
## version 1.0.2
###### 変更点
- 入れ替える文字（プラグボードのプラグ）を指定できるようにアップデート。returnRotor変数、retrunNum()関数をそれぞれreflector変数、reflector()関数に名義変更。
## version 1.0.1
###### 変更点
- ローター4を追加。コード、コメントアウトを微修正。
## version 1.0.0
- Enigmaはじめてみました。
