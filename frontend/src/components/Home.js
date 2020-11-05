import React from 'react';
import RaisedButton from 'material-ui/RaisedButton'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import ProductService from '../services/ProductService';

class Home extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            products: [],
            width: 0
        }
    }

    componentDidMount() {
        ProductService.getProducts().then((response) => {
            this.setState({
                products: response.data
            })
        });

        this.updateWidth();
    }

    updateWidth = () => {
        this.setState({
            width: parseInt((this.refs.container.offsetWidth - 100) / 210, 10)
        });
    }

    addToCart = () => {

    }

    getImage = (image) => {
        try {
            return require('../assets/items/' + image + '.jpg');
        } catch
        {
            console.log(image + ".jpg no existe")
        }
    }

    item = (props) => { //aqui la idea es  manejar todo el almacen con redux. pero aun no se usarlo bien y me quedé sin tiempo. así que solo quemé los datos
        return (
            <div style={{
                margin: 5,
                width: 200,
                height: 450,
                fontSize: 15,
                border: '1px solid red',
                borderColor: 'black',
                borderWidth: 3,
                textAlign: 'center',
            }}>
                <img src={this.getImage(props.image)} width='200px' height='200px' />
                <h1>{props.title}</h1>
                <h3>Price: ${props.price} USD</h3>
                <h6>Stock: {props.stock}</h6>
                <MuiThemeProvider>
                    <RaisedButton label="Add To Cart" primary={true} style={{ margin: 15 }} onClick={() => this.addToCart()} />
                </MuiThemeProvider>
            </div>
        );
    }

    render() {
        return (
            <div style={{
                height: "100vh",
                width: "100vh - 20",
                background: "#ff00ff",
                padding: 50,
                display: 'flex'
            }} ref="container">
                {this.state.width}
                {
                    this.state.products.map(
                        product =>
                            this.item({
                                image: product.photo,
                                title: product.name,
                                price: product.usd,
                                stock: product.stock
                            })
                    )
                }
            </div>
        );
    }
}

export default Home;