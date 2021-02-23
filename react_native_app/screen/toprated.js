import React, {PureComponent} from 'react';
import {Text,View, Image, FlatList, ScrollView, TouchableOpacity, StyleSheet} from 'react-native';
import { Card, ListItem, Button, Icon } from 'react-native-elements'


const styles = StyleSheet.create({
  
  container: {
      backgroundColor: "black"
  },
  cardTitle:{
    fontSize: 20,
      color:"white",
      fontWeight: "bold"
  }

  });

class topRated extends PureComponent{

    constructor(props){
        super(props);
        this.state={
            name:"TopRated"
        }
    }

async componentDidMount(){
    console.log("cdm");
    const res = await fetch("https://api.themoviedb.org/3/movie/top_rated?api_key=5b0847ff411e343281e0fb0279ef27a1&language=en-US&page=1").then((res)=>{
      
        return res.json();
    }).then(jsonData=>{
        
        this.setState({
            data: jsonData,
        })
    });
    
}

render(){

const {data} = this.state;

return(
   
<ScrollView style={styles.container}>

    <Card >
  
  <Card.Divider/>
  {
    data?.results.map( item =>  {
      return (
        <TouchableOpacity key={item.title} onPress={() => this.props.navigation.navigate('MovieDetails',item)}>
        <View style={styles.container}>
          
          <Card.Title style={styles.cardTitle}>{item.title}</Card.Title>
        </View>
        <Card.Divider/>
        </TouchableOpacity>
      );
    })
  }
</Card>

</ScrollView>
)
}
}

export default topRated;