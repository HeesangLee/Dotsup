# Dotsup
2D puzzle game using libgdx

## Schedule
크리스마스 전까지 완료 목표 
* Design : 완료
* Project setup : 완료
* Splash screen : ~11/20.. 항상 계획데로 되는게 없네... 오늘은 결혼기념일...
* Menu screen : ~11/23
* Game screen : ~11/30

벌써 12월이다.....12월에는 1차 완료 반드시 하고, 1월에 보강하면서 수익을 보고 2월에 그만 두는 계획을 실행할 것.

## Notes
* Touch input으로 읽은 Y 좌표의 origin 이 top-left 임. (Graphic 은 bottom-left)
    * AndEngine 은 둘다 top-left 였던 거 같은데.....
* MenuScreen 에서 배경 원들을 우선은 하나의 이미지로 그냥 붙히고... 나중에 개별 원들을 Animation effect를 적용할지는 진행하면서 결정할 것.
    * 미시적인 것에 얶메이지 말자.        
* SpriteNumber Class 조금 이상함.... 나중에 다시 만들던지...

### Input processor for each entities
내장 Button 을 사용하지 않고 개별 개체에 대해서 Input event 처리하기
* GestureListener 를 상속하는 객체를 만들고 Screen 에서 GestureDetect 시 각 객체의 Gesture에 event 전달하는 식으로...

### Button
* button image --> bg 를 Sprite로 만들고 Color 지정하는 방식으로 할 수도 있음.
    1. Floating
    2. Touch down


Effect
1. Move x/y : GameObject 에 적용 완료
2. Size, Color 등은 Sprite에 적용되어야 함으로 별도로 만들어야 함.
    * Dots에 만든 뒤에 별도로 분리해서 extends 하도록 할 것.
    

