# Circular Switch with Text and Background 
[![](https://jitpack.io/v/ateebakhtar/Circular_Switch_with_Text.svg)](https://jitpack.io/#ateebakhtar/Circular_Switch_with_Text) 

This library is used to make a circular bordered switch and changeable text and background, there are custom on click methods that switch background and text color automatically.

![Screen Shot](screenshot.jpg)

## Installation

Add it in your root build.gradle at the end of repositories:

```bash
maven { url 'https://jitpack.io' }
```

Add the dependency:

```bash
implementation 'com.github.ateebakhtar:Circular_Switch_with_Text:1.1.0'
```


## Usage

Insert in the xml of your respective main file

```xml
 <com.ateeb.switchwithtext.CircularSwitch
        android:id="@+id/circle_center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />
```
Use this is in your Kotlin file

```kotlin
val circularSwitch = findViewById<CircularSwitch>(R.id.circle_center)
circularSwitch.setOffButton("Post") {
     Toast.makeText(this, "Post", Toast.LENGTH_SHORT).show()
}
circularSwitch.setOnButton("Photos") {
     Toast.makeText(this, "Photos", Toast.LENGTH_SHORT).show()
}
```

Use this is in your Java file
```Java
CircularSwitch circularSwitch;
private void init() {
    circularSwitch = findViewById(R.id.circle_center);
    circularSwitch.setOnButton("On",openOn);
    circularSwitch.setOffButton("Off",openOff);
}

private View.OnClickListener openOn = new View.OnClickListener() {
    public void onClick(View v) {
        //todo add logic here
    }
};

private View.OnClickListener openOff = new View.OnClickListener() {
    public void onClick(View v) {
        //todo add logic here
    }
};
```
## Additional Properties
 
Additional Properties in XML
```xml
app:activeButtonTextColor="@color/green"
app:positiveButtonTextColorForInactive="@color/black"
app:negativeButtonTextColorForInactive="@color/black"
app:setPositiveAsActive="false"
```
Additional Properties in Java
```java
circularSwitch.setActiveButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
circularSwitch.setInActiveNegativeButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
circularSwitch.setInActivePositiveButtonColor(ResourcesCompat.getColor(getResources(),R.color.grey,null));
circularSwitch.setPostiveActive(false);
```

Additional Properties in Kotlin
```kotlin
circularSwitch.activeButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
circularSwitch.inActiveNegativeButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
circularSwitch.inActivePositiveButtonColor = ResourcesCompat.getColor(resources, R.color.grey, null)
circularSwitch.postiveActive = false
```
