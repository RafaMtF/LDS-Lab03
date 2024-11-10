import React from "react";

const BtnGoBack = () => {
  const goBack = () => {
    window.history.back();
  };

  return (
    <button
      className="h-[50px] w-[150px] bg-slate-300 border-0 rounded-md fixed bottom-5 right-5 md:bottom-10 md:left-10"
      onClick={goBack}
    >
      Go Back
    </button>
  );
};

export default BtnGoBack;
