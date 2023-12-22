import logo from './logo.svg';
import './App.css';
import  axios  from 'axios';
import Navbar from './layouts/NavbarAndFooter/Navbar';
import TopPlayerLastWeek from './layouts/Homepage/components/TopPlayerLastWeek';
import Homepage from './layouts/Homepage/Homepage';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Homepage/>
    </div>
  );
}

export default App;
