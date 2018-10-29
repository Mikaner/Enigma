# Enigma
えにぐま＠がんばる
## version 1.0.1
###### 変更点
- ローター4を追加。コード、コメントアウトを微修正。
###### 使い方
- とりあえず、コンパイルです。
  1. `javac .\Enigma.java`などと打ってコンパイルしてください。`javac`がない場合はインストールして環境を整えてきてください。
  2. `java Enigma`と打ってEnigmaを起動してください
  3. 急に止めたくなった場合は`ctrl+Z`か`ctrl+C`を押して強制終了してください。

- 次に、セッティングです。
  1. First Rotorと出るので、一番目のローターの番号と一番上の文字をセットしてください。(version 1.0.1現在ではローターは4つあります。文字は英字の大文字のみ対応しています)
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

  4. Exchangeと出るので、入れ替えたい文字を二つ指定してください。
  ```:入力例
  First Rotor
  1 A
  Second Rotor
  2 B
  Third Rotor
  3 C
  Exchange
  A Z
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
  A Z
  3
   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
   Z B C D E F G H I J K L M N O P Q R S T U V W X Y A
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
  NPR
  ```
  ```:出力例(空白を入れた場合)
  Please type a message here.
  A AA
  N
  PR
  ```

  3. 終了するときは`"exit"`と入力してください。
  ```:入力例
  Please type a message here.
  AAA
  NPR
  "exit"
  ```

  4. 復号する際は、起動しなおして、セッティングの1から同じ設定にしてください。
## version 1.0.0
- Enigmaはじめてみました。
