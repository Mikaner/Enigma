# Enigma
えにぐま＠がんばる
## 注意事項
- 想定されていない文字を入力すると終了するので気を付けてください。
- 本文の入力で大文字アルファベット以外の文字を入力するとぬるぽ出して強制終了するので気を付けてください。
- 
- 間違えて何も入力しないで改行をした場合は、特に気にしないで入力しちゃって大丈夫です。
- Settingのアルファベット入力時に文章を入力した場合、始めの一文字が設定されます。
## version 1.2.0
###### 変更点
- 桁上げの位置を設定できるように変更
- 各ローターの使用者側の表示での名称を変更
- inputとoutputの表示を変更
- 注意事項を追加

###### 使い方
- とりあえず、コンパイルです。
  1. `javac .\Enigma.java`などと打ってコンパイルしてください。`javac`がない場合はインストールして環境を整えてきてください。
  2. `java Enigma`と打ってEnigmaを起動してください
  3. 急に止めたくなった場合は`0`を入力して終了してください。

- 次に、セッティングです。
  1. First Rotorと出るので、一番目のローターの番号と一番上の文字、桁上げ時の文字を、それぞれ数字とアルファベットを入力してセットしてください。(version 1.1.2現在ではローターは5つあります。文字は英字の大文字のみ対応しています)
  __callyDigitは大文字アルファベットで入力してください。__ 間違いやすい記述ですみません。
  ```:入力例
  --Setting--
  First Rotor
   Number  :>1
   Alphabet:>A
   callyDigit:>D
  ```

  2. Second Rotorと出るので、二番目のローターの番号と一番上の文字をセットしてください。
  ```:入力例
  First Rotor
   Number  :>1
   Alphabet:>A
   callyDigit:>D
  Medium Rotor
   Number  :>2
   Alphabet:>B
   callyDigit:>C
  ```

  3. Third Rotorと出るので、三番目のローターの番号と一番上の文字をセットしてください。
  ```:入力例
  First Rotor
   Number  :>1
   Alphabet:>A
   callyDigit:>D
  Medium Rotor
   Number  :>2
   Alphabet:>B
   callyDigit:>C
  Slow Rotor
   Number  :>3
   Alphabet:>C
   callyDigit:>A
  ```

  4. Exchangeと出るので、入れ替えたい文字の数と入れ替えたい文字を、それぞれ数字またはアルファベットを入力して指定してください。
  ```:入力例
  First Rotor
   Number  :>1
   Alphabet:>A
   callyDigit:>D
  Medium Rotor
   Number  :>2
   Alphabet:>B
   callyDigit:>C
  Slow Rotor
   Number  :>3
   Alphabet:>C
   callyDigit:>A
  Reflecter
  Number of plugs:>3
  A Z
  B C
  X Y
  ```

  5. 現在あるローターの数と、対応しているA~Zの入れ替える前、入れ替えた後が出力されたら、セッティングは終了です。
  ```:出力例
  First Rotor
   Number  :>1
   Alphabet:>A
   callyDigit:>D
  Medium Rotor
   Number  :>2
   Alphabet:>B
   callyDigit:>C
  Slow Rotor
   Number  :>3
   Alphabet:>C
   callyDigit:>A
  Reflecter
  Number of plugs:>3
  A Z
  B C
  X Y
  3
   A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
   Z C B D E F G H I J K L M N O P Q R S T U V W Y X A
  --Main--
  Please type a message here.
  ```
- この後は文字を入力します
  1. 英字の大文字を入力してください。(空白を入れると改行されて出力されます。)
  ```:入力例
  --Main--
  Please type a message here.
  <input>
  AAA
  ```

  2. 変換後の文字が出力されます。
  ```:出力例
  Please type a message here.
  <input>
  AAA
  <output>
  TIN
  ```
  ```:出力例(空白を入れた場合)
  Please type a message here.
  <input>
  A AA
  <output>
  T
  IN
  ```

  3. 終了するときは`0`と入力してください。
  ```:入力例
  Please type a message here.
  <input>
  AAA
  <output>
  TIN
  <input>
  0
  ```

  4. 復号する際は、起動しなおして、セッティングの1から同じ設定にしてください。
## version 1.1.3
###### 変更点
- なんだかな続きで想定されていない文字を入力してもエラー終了しないように修正した。あと入力がわかりにくいっぽかったので修正。
## version 1.1.2
###### 変更点
- 流石に強制終了はなんだかなってことで各場所で`0`を打つと終了するように変更。想定と別範囲の文字入れられてもなんだかなってことで正確な文字を入力されるまでループするように変更。
## version 1.1.1
###### 変更点
- reRotor.pyの処理をRotor.javaの中に移動。
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
