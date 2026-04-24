import { create } from "zustand";
import { persist } from "zustand/middleware";

export const usePersistStore = create(
  persist(
    (set) => ({
      theme: "light",
      thoggleTheme: () =>
        set((state) => ({
          theme: state.theme === "light" ? "dark" : "light",
        })),
    }),
    {
      name: "theme-storage",
    },
  ),
);
