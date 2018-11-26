# Dotsup
2D puzzle game using libgdx

## Schedule
크리스마스 전까지 완료 목표 
* Design : 완료
* Project setup : 완료
* Splash screen : ~11/20.. 항상 계획데로 되는게 없네... 오늘은 결혼기념일...
* Menu screen : ~11/23
* Game screen : ~11/30

## Notes
### Input processor for each entities
내장 Button 을 사용하지 않고 개별 개체에 대해서 Input event 처리하기
* Implement touchableEntity
    * setTouchArea()
    * isInTouchArea()

Effect
1. Move x/y : GameObject 에 적용 완료
2. Size, Color 등은 Sprite에 적용되어야 함으로 별도로 만들어야 함.
    * Dots에 만든 뒤에 별도로 분리해서 extends 하도록 할 것.
