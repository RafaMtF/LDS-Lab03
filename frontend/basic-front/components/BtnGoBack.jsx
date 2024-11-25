import React from "react";

const BtnGoBack = () => {
  const goBack = () => {
    window.history.back();
  };

  return (
    <button
      className="h-[50px] w-[150px] bg-[#EDF5FC] border-2 border-[#B8C5D6] rounded-md fixed bottom-5 right-5 md:bottom-10 md:left-10"
      onClick={() => window.history.back()}
    >
      Go Back
    </button>
  );
};

export default BtnGoBack;
