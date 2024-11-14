import { useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import './App.css';

const Datepicker = () => {
  const [selectedDate, setSelectedDate] = useState<Date | null>(null);

  return (
    <div className="datepicker-container">
      <DatePicker
        selected={selectedDate}
        onChange={(date: Date | null) => setSelectedDate(date)}
      />
    </div>
  );
};

export default Datepicker;