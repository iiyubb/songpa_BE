import { create } from "zustand";

export const useCartStore = create((set) => ({
    items: [],

    addItem: (item) => set((state) => ({
        items: [...state.items, item]   
        // 기존의 배열을 직접 수정(push) 하면 안되고, 반드시 새로운 배열로 복사해서 
        // 교체하여야 React가 상태 바뀐 걸 눈치채고 화면을 다시 그린다.
    })),

    removeItem: (id) => set((state) => ({
        items: state.items.filter((item) => item.id !== id)
    })),

    clearCart: () => set({ items: [] })
}));