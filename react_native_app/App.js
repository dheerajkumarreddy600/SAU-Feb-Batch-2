
import 'react-native-gesture-handler';
import React from 'react';
import { StyleSheet} from 'react-native';
import {NavigationContainer} from '@react-navigation/native';
import {createStackNavigator} from '@react-navigation/stack';
import { createBottemTabNavigator} from '@react-navigation/bottom-tabs';
import {Upcoming} from './screen/upcoming';
import {topRated} from './screen/popular';
import {Popular} from './screen/toprated';

const upst = createStackNavigator();
function Upcome(){
  return(
    <upst.Navigator>
      <upst.Screen name="Up" component={Upcoming} />
    </upst.Navigator>
  );
}
const popst=createStackNavigator();
function pop(){
  return(
    <popst.Navigator>
      <popst.Screen name="pop" component={Popular}></popst.Screen>
    </popst.Navigator>
  );
}
const topst=createStackNavigator();
function top(){
  return(
    <topst.Navigator>
      <topst.Screen name="top" component={topRated}></topst.Screen>
    </topst.Navigator>
  );
}
 const tab=createBottemTabNavigator();
 
function App() {
  return (
      <NavigationContainer>
        <tab.Navigator >
          <tab.Screen name="up" component={Upcome}/>
          <tab.Screen name="top" component={top}/>
          <tab.Screen name="Pop" component={pop}/>

        </tab.Navigator>
      </NavigationContainer>
    );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
export default App;