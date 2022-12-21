package com.support;

import com.views.FileOperationView;
import com.views.Views;
import com.views.WelcomeView;

public class ViewSupport {

public static WelcomeView WelcomeView = new WelcomeView();
public static FileOperationView FileOperationView = new FileOperationView();



public static Views CurrentView = WelcomeView;


public static Views getCurrentView() {
return CurrentView;
}


public static void setCurrentView(Views currentView) {
CurrentView = currentView;
}

}
