import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import TwitterFollowCard from './TwitterFollowCard';
import Login2 from './Login2';
import ClassroomList from './ClassroomList';
import Classroom from './Classroom'

const App = () => {
  return (
      <Routes>
        <Route path="/twiterFollowCard" element={<TwitterFollowCard />} />
        <Route path="/" element={<Login2 />} />
        <Route path="/myClasses" element={<ClassroomList/>} />
        <Route path="/classroom/:idClassroom" element={<Classroom></Classroom>}/>
      </Routes>
  );
};

export default App;

